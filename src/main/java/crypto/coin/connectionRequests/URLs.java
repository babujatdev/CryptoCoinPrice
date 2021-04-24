package crypto.coin.connectionRequests;

public interface URLs {
    String mainUrl = "https://api.coingecko.com/api/";
    String version = mainUrl + "v3/";
    String ping = version + "ping";
    String pricesUS = version + "simple/price?ids=ethereum&vs_currencies=usd&include_market_cap=true&include_24hr_vol=true&include_last_updated_at=true";
    String pricesCA = version + "simple/price?ids=ethereum&vs_currencies=cad&include_market_cap=true&include_24hr_vol=true&include_last_updated_at=true";
    String dogerate = "https://jettysoftcloudapi.eastus.cloudapp.azure.com/Jettysoft_Web_API/jettyweb/doge/priceestimate?token=JettySoftDoge737826362731";
    String openingBalance = "https://jettysoftcloudapi.eastus.cloudapp.azure.com/Jettysoft_Web_API/jettyweb/doge/openingbalance?token=JettySoftDoge737826362731";
}
