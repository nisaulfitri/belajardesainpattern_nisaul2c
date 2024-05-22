package Percobaan2;

class Main {
    public static void main(String[] args) {
        try {
            BookRepo bookRepo = new BookRepo();
            BookSummaryService service = new BookSummaryService(bookRepo);

            BookReq req = new BookReq();
            req.setGrouping("author");
            service.printSummary(req);

            req.setGrouping("dateReleased");
            service.printSummary(req);

            req.setGrouping("category");
            service.printSummary(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}