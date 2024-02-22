package de.comcave.fotobuch.covers;

public class HardCover extends Cover {

    private static final int HARDCOVER_BASE_PRICE = 10;
    private static final int HARDCOVER_INCLUDED_PAGES = 8;
    private static final int HARDCOVER_ADDITIONAL_PAGE_PRICE = 4;
    private static final int HARDCOVER_BASE_WEIGHT = 320;
    private static final int HARDCOVER_MAX_PAGES = 80;

    public HardCover(String title, int totalPages) {
        super(title, totalPages, HARDCOVER_BASE_PRICE, HARDCOVER_INCLUDED_PAGES, HARDCOVER_ADDITIONAL_PAGE_PRICE, HARDCOVER_BASE_WEIGHT, HARDCOVER_MAX_PAGES);
    }

    public HardCover() {
        super(HARDCOVER_MAX_PAGES);
    }

    @Override
    public double calculatePrice(int totalPages) {
        return basePrice + (Math.ceil((double) (totalPages - includedPages) / 4) * additionalPagePrice);
    }

    @Override
    public int calculateWeight(int totalPages) {
        return totalPages <= includedPages ? baseWeight : baseWeight + ((totalPages - includedPages) * 20);
    }
}