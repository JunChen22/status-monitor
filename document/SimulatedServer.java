import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulatedServer {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: java SimulatedServer <port>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new PhasedHandler());
        server.setExecutor(Executors.newFixedThreadPool(1));
        System.out.println("Starting server on port " + port + "...");
        server.start();
    }

    static class PhasedHandler implements HttpHandler {
        private static final long NORMAL_DURATION = 2 * 60 * 1000; // 2 minutes
        private static final long HIGH_TRAFFIC_DURATION = 1 * 60 * 1000; // 1 minute
        private static final long DOWN_TIME_DURATION = 1 * 60 * 1000; // 1 minute

        private long startTime = System.currentTimeMillis();
        private enum Phase { NORMAL, HIGH_TRAFFIC, DOWN }
        private Phase currentPhase = Phase.NORMAL;

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            updatePhase();
            long delay = getDelayForCurrentPhase();
            if (currentPhase == Phase.DOWN) {
                // Simulate downtime
                exchange.sendResponseHeaders(503, -1);
                return;
            }
            
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            String response = "Response in " + delay + " ms";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        private void updatePhase() {
            long elapsed = System.currentTimeMillis() - startTime;
            if (elapsed < NORMAL_DURATION) {
                currentPhase = Phase.NORMAL;
            } else if (elapsed < NORMAL_DURATION + HIGH_TRAFFIC_DURATION) {
                currentPhase = Phase.HIGH_TRAFFIC;
            } else if (elapsed < NORMAL_DURATION + HIGH_TRAFFIC_DURATION + DOWN_TIME_DURATION) {
                currentPhase = Phase.DOWN;
            } else {
                startTime = System.currentTimeMillis();
            }
        }

        private long getDelayForCurrentPhase() {
            Random random = new Random();
            switch (currentPhase) {
                case HIGH_TRAFFIC:
                    return random.nextInt(300) + 500; // High traffic response time
                case NORMAL:
                default:
                    return random.nextInt(20) + 70;  // Normal response time
            }
        }
    }
}