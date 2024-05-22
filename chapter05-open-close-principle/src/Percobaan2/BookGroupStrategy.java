package Percobaan2;

interface BookGroupStrategy {
    BookSummary getBookSummary(BookReq req);
}

class BookSummaryByAuthor implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByAuthor(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        long total = bookRepo.countBookGroupByAuthor(req);
        long sum = bookRepo.sumBookPriceGroupByAuthor(req);
        //another huge logic about book group by author
        //...
        //
        return BookSummary.builder()
                .groupName("By Author")
                .sumBookPrice(sum)
                .totalBook(total)
                .build();
    }
}

class BookSummaryByReleasedDate implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByReleasedDate(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        long total = bookRepo.countBookGroupByDateReleased(req);
        long sum = bookRepo.sumBookPriceGroupByDateReleased(req);
        //another huge logic about book group by dateReleased
        //...
        //
        return BookSummary.builder()
                .groupName("By Release Date")
                .sumBookPrice(sum)
                .totalBook(total)
                .build();
    }
}

class BookSummaryByCategory implements BookGroupStrategy {
    private final BookRepo bookRepo;

    public BookSummaryByCategory(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        long total = bookRepo.countBookGroupByCategory(req);
        long sum = bookRepo.sumBookPriceGroupByCategory(req);
        //another huge logic about book group by category
        //...
        //
        return BookSummary.builder()
                .groupName("By Category")
                .sumBookPrice(sum)
                .totalBook(total)
                .build();
    }
}

class BookSummaryService {
    private final BookRepo bookRepo;

    public BookSummaryService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void printSummary(BookReq req) throws Exception {
        BookGroupStrategy strategy;
        if ("category".equals(req.getGrouping())) {
            strategy = new BookSummaryByCategory(bookRepo);
        } else if ("dateReleased".equals(req.getGrouping())) {
            strategy = new BookSummaryByReleasedDate(bookRepo);
        } else if ("author".equals(req.getGrouping())) {
            strategy = new BookSummaryByAuthor(bookRepo);
        } else {
            throw new Exception("No grouping found");
        }

        BookSummary books = strategy.getBookSummary(req);
        System.out.println("groupName = " + books.getGroupName());
        System.out.println("total = " + books.getTotalBook());
        System.out.println("sum price = " + books.getSumBookPrice());
    }
}

// Assuming these classes exist:
class BookRepo {
    public long countBookGroupByAuthor(BookReq req) {
        // mock implementation
        return 10;
    }

    public long sumBookPriceGroupByAuthor(BookReq req) {
        // mock implementation
        return 100;
    }

    public long countBookGroupByDateReleased(BookReq req) {
        // mock implementation
        return 20;
    }

    public long sumBookPriceGroupByDateReleased(BookReq req) {
        // mock implementation
        return 200;
    }

    public long countBookGroupByCategory(BookReq req) {
        // mock implementation
        return 30;
    }

    public long sumBookPriceGroupByCategory(BookReq req) {
        // mock implementation
        return 300;
    }
}

class BookReq {
    private String grouping;

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }
}

class BookSummary {
    private String groupName;
    private long sumBookPrice;
    private long totalBook;

    public String getGroupName() {
        return groupName;
    }

    public long getSumBookPrice() {
        return sumBookPrice;
    }

    public long getTotalBook() {
        return totalBook;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String groupName;
        private long sumBookPrice;
        private long totalBook;

        public Builder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder sumBookPrice(long sumBookPrice) {
            this.sumBookPrice = sumBookPrice;
            return this;
        }

        public Builder totalBook(long totalBook) {
            this.totalBook = totalBook;
            return this;
        }

        public BookSummary build() {
            BookSummary summary = new BookSummary();
            summary.groupName = this.groupName;
            summary.sumBookPrice = this.sumBookPrice;
            summary.totalBook = this.totalBook;
            return summary;
        }
    }
}
