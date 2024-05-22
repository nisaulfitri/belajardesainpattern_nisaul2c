package Percobaan1;

// Interface for BookRepo
interface BookRepo {
    long countBookGroupByCategory(BookReq req);
    long sumBookPriceGroupByCategory(BookReq req);
    long countBookGroupByDateReleased(BookReq req);
    long sumBookPriceGroupByDateReleased(BookReq req);
    long countBookGroupByAuthor(BookReq req);
    long sumBookPriceGroupByAuthor(BookReq req);
}

// BookReq class
class BookReq {
    private String grouping;

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }
}

// BookSummary class with builder pattern
class BookSummary {
    private String groupName;
    private long totalBook;
    private long sumBookPrice;

    public static Builder builder() {
        return new Builder();
    }

    public String getGroupName() {
        return groupName;
    }

    public long getTotalBook() {
        return totalBook;
    }

    public long getSumBookPrice() {
        return sumBookPrice;
    }

    public static class Builder {
        private String groupName;
        private long totalBook;
        private long sumBookPrice;

        public Builder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder totalBook(long totalBook) {
            this.totalBook = totalBook;
            return this;
        }

        public Builder sumBookPrice(long sumBookPrice) {
            this.sumBookPrice = sumBookPrice;
            return this;
        }

        public BookSummary build() {
            BookSummary summary = new BookSummary();
            summary.groupName = this.groupName;
            summary.totalBook = this.totalBook;
            summary.sumBookPrice = this.sumBookPrice;
            return summary;
        }
    }
}

// Mock implementation of BookRepo for testing purposes
class MockBookRepo implements BookRepo {
    @Override
    public long countBookGroupByCategory(BookReq req) {
        return 10; // Mock data
    }

    @Override
    public long sumBookPriceGroupByCategory(BookReq req) {
        return 200; // Mock data
    }

    @Override
    public long countBookGroupByDateReleased(BookReq req) {
        return 15; // Mock data
    }

    @Override
    public long sumBookPriceGroupByDateReleased(BookReq req) {
        return 300; // Mock data
    }

    @Override
    public long countBookGroupByAuthor(BookReq req) {
        return 8; // Mock data
    }

    @Override
    public long sumBookPriceGroupByAuthor(BookReq req) {
        return 150; // Mock data
    }
}

// BookSummaryService class
class BookSummaryService {
    private final BookRepo bookRepo;

    public BookSummaryService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void printSummary(BookReq req) throws Exception {
        BookSummary books;
        if ("category".equals(req.getGrouping())) {
            long total = bookRepo.countBookGroupByCategory(req);
            long sum = bookRepo.sumBookPriceGroupByCategory(req);
            // Another huge logic about book group by category
            books = BookSummary.builder()
                    .groupName("By Category")
                    .sumBookPrice(sum)
                    .totalBook(total)
                    .build();
        } else if ("dateReleased".equals(req.getGrouping())) {
            long total = bookRepo.countBookGroupByDateReleased(req);
            long sum = bookRepo.sumBookPriceGroupByDateReleased(req);
            // Another huge logic about book group by dateReleased
            books = BookSummary.builder()
                    .groupName("By Release Date")
                    .sumBookPrice(sum)
                    .totalBook(total)
                    .build();
        } else if ("author".equals(req.getGrouping())) {
            long total = bookRepo.countBookGroupByAuthor(req);
            long sum = bookRepo.sumBookPriceGroupByAuthor(req);
            // Another huge logic about book group by author
            books = BookSummary.builder()
                    .groupName("By Author")
                    .sumBookPrice(sum)
                    .totalBook(total)
                    .build();
        } else {
            throw new Exception("No grouping found");
        }

        System.out.println("groupName = " + books.getGroupName());
        System.out.println("total = " + books.getTotalBook());
        System.out.println("sum price = " + books.getSumBookPrice());
    }
}
