import java.util.List;

class EnrollmentProjection {

    //Seperate Historical Data into h(da) and h(db) in order to return h(d)
    public static double interpolateEnrollment(double d, List<Double> historicalDates, List<Double> historicalEnrollments) {
        for (int i = 0; i < historicalDates.size() - 1; i++) {
            double da = historicalDates.get(i);
            double db = historicalDates.get(i + 1);
            if (d >= da && d <= db) {
                double ha = historicalEnrollments.get(i);
                double hb = historicalEnrollments.get(i + 1);
                return ha + (d - da) / (db - da) * (hb - ha);
            }
        }
        throw new IllegalArgumentException("Date d is out of bounds for historical data");
    }

    //Interpolarion based on the formula 3.2.1
    public static double projectFinalEnrollment(double currentEnrollment, double currentDate, double historicalFinalEnrollment, List<Double> historicalDates, List<Double> historicalEnrollments) {
        double historicalEnrollmentOnCurrentDate = interpolateEnrollment(currentDate, historicalDates, historicalEnrollments);
        return currentEnrollment * (historicalFinalEnrollment / historicalEnrollmentOnCurrentDate);
    }

    public static double curveSmoothing(List<double> currentEnrollment, List<double> historicalEnrollments){
    double c1 = currentEnrollment.getlast();
    double h1 = historicalEnrollments.getlast();

    return c1 / h1;
    }