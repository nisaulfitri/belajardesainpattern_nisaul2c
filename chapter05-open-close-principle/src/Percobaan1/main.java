package Percobaan1;


class Main {
    public static void main(String[] args) {
        // Create a mock BookRepo (you should replace this with an actual implementation)
        BookRepo bookRepo = new MockBookRepo();

        // Create a BookSummaryService instance
        BookSummaryService bookSummaryService = new BookSummaryService(bookRepo);

        // Create a BookReq instance (example: grouping by category)
        BookReq req = new BookReq();
        req.setGrouping("category");

        try {
            // Call the printSummary method
            bookSummaryService.printSummary(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

