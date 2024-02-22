package de.comcave.fotobuch.covers;

public class SoftCover extends Cover {

    private static final int SOFTCOVER_BASE_PRICE = 6;
    private static final int SOFTCOVER_INCLUDED_PAGES = 12;
    private static final int SOFTCOVER_ADDITIONAL_PAGE_PRICE = 3;
    private static final int SOFTCOVER_BASE_WEIGHT = 200;
    private static final int SOFTCOVER_MAX_PAGES = 40;

    public SoftCover(String title, int totalPages) {
        super(title, totalPages, SOFTCOVER_BASE_PRICE, SOFTCOVER_INCLUDED_PAGES, SOFTCOVER_ADDITIONAL_PAGE_PRICE, SOFTCOVER_BASE_WEIGHT, SOFTCOVER_MAX_PAGES);
    }

    public SoftCover() {
        super(SOFTCOVER_MAX_PAGES);
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