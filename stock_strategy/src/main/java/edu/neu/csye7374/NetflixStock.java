package edu.neu.csye7374;

public class NetflixStock extends Stock {

    public NetflixStock() {
        this.setName("NFLX");
        this.setDescription("Netflix is a streaming service that offers a wide variety of award-winning TV shows, movies, anime, documentaries, and more on thousands of internet-connected devices.");
        this.setPrice(396.20);
    }

    @Override
    public MarketCap marketCap() {
        return MarketCap.LARGE;
    }

}
