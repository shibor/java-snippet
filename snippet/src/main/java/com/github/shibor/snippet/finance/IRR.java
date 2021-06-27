package com.github.shibor.snippet.finance;

/**
 * 内部收益率
 *
 *
 * <pre>
 *
 * values 必须包含至少一个正值和一个负值，以计算返回的内部收益率。
 *
 * IRR 使用值的顺序来说明现金流的顺序。 一定要按您需要的顺序输入支出值和收益值。
 *
 * Guess可选。 对函数 IRR 计算结果的估计值。
 *
 * Microsoft Excel 使用一种迭代技术来计算 IRR。 从 guess 开始, IRR 循环遍历计算, 直到结果在 0.00001% 范围内精确。
 *
 * 如果 IRR 在尝试20次后找不到结果, 则 #NUM! 错误值。
 * 如果省略 guess，则假定它为 0.1 (10%)。
 *
 * </pre>
 *
 * @author shibor
 */
public class IRR {

    private static final double MIND_IF = .0000001;
    private static final int MAX_Iteration_Count = 20;

    public static double irr(double[] values) {
        return irr(values, 0.1D);
    }


    /**
     * 使用牛顿迭代的方式求解
     *
     * @param values 现金流
     * @param guess  预计折现率
     * @return irr值
     */
    public static double irr(double[] values, double guess) {

        double sum = 0D;
        int ineg = 0;
        int ipos = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
            if (values[i] > 0) {
                ipos++;
            } else if (values[i] < 0) {
                ineg++;
            }
        }
        if (ineg == 0 || ipos == 0) {
            return Double.NaN;
        }
        if (sum < 0) {
            guess = -Math.abs(guess);
        } else {
            guess = Math.abs(guess);
        }


        double x0 = guess;
        int i = 0;
        while (i < MAX_Iteration_Count) {
            double npvValue = 0.0D;
            double npvDerivative = 0.0D;
            for (int j = 0; j < values.length; j++) {
                npvValue += values[j] / Math.pow(1.0D + x0, j);
                npvDerivative += -j * values[j] / Math.pow(1.0D + x0, j + 1);
            }
            double x1 = x0 - npvValue / npvDerivative;
            if (Math.abs(x1 - x0) <= MIND_IF) {
                return x1;
            }
            x0 = x1;
            i++;
        }
        return Double.NaN;
    }


    /**
     * 净现值
     *
     * @param rate   折现率
     * @param values 现金流
     * @return irr值
     */
    public static double npv(double rate, double[] values) {
        if (values.length == 0) {
            return Double.NaN;
        }
        double npv = 0;
        for (int i = 0; i < values.length; i++) {
            npv += values[i] / Math.pow(1.0 + rate, i + 1);
        }
        return npv;
    }


    public static void main(String[] args) {
        double[] income = {-700000, 120000, 150000, 180000, 210000, 260000};

        double irr = irr(income);
        System.out.println("irr: " + irr);

        double npv = npv(0.0866309480365222, income);
        System.out.printf("npv: %f \n", npv);
    }
}
