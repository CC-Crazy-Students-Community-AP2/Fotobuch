package de.comcave.fotobuch.covers;

import lombok.Getter;

public abstract class Cover {

    protected String title;
    protected int totalPages;
    protected double basePrice;
    protected int includedPages;
    protected int additionalPagePrice;
    protected int baseWeight;
    @Getter
    protected int maxPages;

    public Cover(String title, int totalPages, double basePrice, int includedPages, int additionalPagePrice, int baseWeight, int maxPages) {
        this.title = title;
        this.totalPages = totalPages;
        this.basePrice = basePrice;
        this.includedPages = includedPages;
        this.additionalPagePrice = additionalPagePrice;
        this.baseWeight = baseWeight;
        this.maxPages = maxPages;
    }

    public Cover(int maxPages) {
        this.maxPages = maxPages;
    }

    public abstract double calculatePrice(int totalPages);
    public abstract int calculateWeight(int totalPages);

    @Override
    public String toString() {
        return String.format("Ihr %s Fotobuch \"%s\" kostet %.2f Euro und wiegt %d Gramm.",
                this.getClass().getSimpleName(),
                title,
                calculatePrice(totalPages),
                calculateWeight(totalPages)
        );
    }
}