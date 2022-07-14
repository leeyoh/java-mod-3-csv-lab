public class LoggerSingleton {

        private int currentLine = 0;
        private static LoggerSingleton logger = null;

        private LoggerSingleton() {
        }

        public static LoggerSingleton getInstance() {
            if (logger == null) {
                logger = new LoggerSingleton();
            }
            return logger;
        }

        public void log(String message) {
            currentLine++;
            System.out.println(currentLine + "::" + message);
        }
}
