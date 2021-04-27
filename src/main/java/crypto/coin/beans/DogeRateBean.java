package crypto.coin.beans;

public class DogeRateBean {
    private String currentPercentage, coinsPumpedDumped, totalCurrentBalance, totalPreviousBalance, estimatedUSDT, currentUSDT, message;
    private int statusCode;

    public String getCurrentPercentage() {
        return currentPercentage;
    }

    public void setCurrentPercentage(String currentPercentage) {
        this.currentPercentage = currentPercentage;
    }

    public String getCoinsPumpedDumped() {
        return coinsPumpedDumped;
    }

    public void setCoinsPumpedDumped(String coinsPumpedDumped) {
        this.coinsPumpedDumped = coinsPumpedDumped;
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

    public String getEstimatedUSDT() {
        return estimatedUSDT;
    }

    public void setEstimatedUSDT(String estimatedUSDT) {
        this.estimatedUSDT = estimatedUSDT;
    }

    public String getCurrentUSDT() {
        return currentUSDT;
    }

    public void setCurrentUSDT(String currentUSDT) {
        this.currentUSDT = currentUSDT;
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