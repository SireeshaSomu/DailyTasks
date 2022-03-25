package selenium.internship;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MathChallenge {
	public int missingNumberInGivenExpression(String str) {

		String operator = "";
		List<String> operandList = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(str, "+-*/=", true);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();

			if ("+-*/".contains(token)) {
				operator = token;
			} else if (!"=".contains(token)) {
				operandList.add(token);
			}
		}

		int result = 0;
		String x;

		String firstOperand = operandList.get(0);
		String secondOperand = operandList.get(1);
		String resultant = operandList.get(2);

		if (resultant.contains("x")) {
			x = resultant;

			int firstOperandVal = Integer.valueOf(firstOperand);
			int secondOperandVal = Integer.valueOf(secondOperand);

			if (operator.equals("+"))
				result = firstOperandVal + secondOperandVal;
			else if (operator.equals("-"))
				result = firstOperandVal - secondOperandVal;
			else if (operator.equals("*"))
				result = firstOperandVal * secondOperandVal;
			else
				result = firstOperandVal / secondOperandVal;
		} else {
			int resultantVal = Integer.valueOf(resultant);

			if (firstOperand.contains("x")) {
				x = firstOperand;

				int secondOperandVal = Integer.valueOf(secondOperand);

				if (operator.equals("+"))
					result = resultantVal - secondOperandVal;
				else if (operator.equals("-"))
					result = resultantVal + secondOperandVal;
				else if (operator.equals("*"))
					result = resultantVal / secondOperandVal;
				else
					result = resultantVal * secondOperandVal;
			} else {
				x = secondOperand;

				int firstOperandVal = Integer.valueOf(firstOperand);

				if (operator.equals("+"))
					result = resultantVal - firstOperandVal;
				else if (operator.equals("-"))
					result = firstOperandVal - resultantVal;
				else if (operator.equals("*"))
					result = resultantVal / firstOperandVal;
				else
					result = firstOperandVal / resultantVal;
			}
		}

		int xIndex = x.indexOf('x');

		result = Integer.valueOf(String.valueOf((String.valueOf(result)).charAt(xIndex)));

		return result;
	}

	@Test
	public void test1() {
		Assert.assertEquals(missingNumberInGivenExpression("4-2=x"), 2);
	}

	@Test
	public void test2() {
		Assert.assertEquals(missingNumberInGivenExpression("3x+12=46"), 4);
	}

}
