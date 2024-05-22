package Percobaan3;

// Example main method to demonstrate usage
class Main {
    public static void main(String[] args) {
        try {
            // Assuming BookRepo, BookReq, and BookSummary are properly defined elsewhere
            BookRepo bookRepo = new BookRepo(); // Initialization of BookRepo
            BookSummaryService service = new BookSummaryService(bookRepo);

            // Example book request
            BookReq req = new BookReq();
            req.setGrouping("category");
            // Add any other required settings to req

            // Print the summary
            service.printSummary(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

