package crypto.coin.beans;

public class DogeRateBean {
    private String currentPercentage, percentageDiff, totalCurrentBalance, totalPreviousBalance, estimatedPrice, currentPrice, message;
    private int statusCode;

    public String getCurrentPercentage() {
        return currentPercentage;
    }

    public void setCurrentPercentage(String currentPercentage) {
        this.currentPercentage = currentPercentage;
    }

    public String getPercentageDiff() {
        return percentageDiff;
    }

    public void setPercentageDiff(String percentageDiff) {
        this.percentageDiff = percentageDiff;
    }

    public String getTotalCurrentBalance() {
        return totalCurrentBalance;
    }

    public void setTotalCurrentBalance(String totalCurrentBalance) {
        this.totalCurrentBalance = totalCurrentBalance;
    }

    public String getTotalPreviousBalance() {
        return totalPreviousBalance;
    }

    public void setTotalPreviousBalance(String totalPreviousBalance) {
        this.totalPreviousBalance = totalPreviousBalance;
    }

    public String getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(String estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}