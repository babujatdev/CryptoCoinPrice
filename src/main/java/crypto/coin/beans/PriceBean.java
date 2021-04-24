package crypto.coin.beans;

public class PriceBean {
    String usd;
    String usd_market_cap;
    String usd_24h_vol;
    String last_updated_at;

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public String getUsd_market_cap() {
        return usd_market_cap;
    }

    public void setUsd_market_cap(String usd_market_cap) {
        this.usd_market_cap = usd_market_cap;
    }

    public String getUsd_24h_vol() {
        return usd_24h_vol;
    }

    public void setUsd_24h_vol(String usd_24h_vol) {
        this.usd_24h_vol = usd_24h_vol;
    }

    public String getLast_updated_at() {
        return last_updated_at;
    }

    public void setLast_updated_at(String last_updated_at) {
        this.last_updated_at = last_updated_at;
    }
}
