package lotto.view;

import java.util.Scanner;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Money;

public class Input {
	private final static Scanner SCANNER = new Scanner(System.in);
	private final static String SPLITER = ", ";

	private Input() {
	}

	private static String nextLine(){
		return SCANNER.nextLine();
	}

	public static Money inputPayment() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			String money = nextLine();
			return new Money(Integer.parseInt(money));
		}catch (NumberFormatException e){
			return inputPayment();
		}
	}

	public static Lotto inputWinnerLotto() {
		try {
			System.out.println("지난 주 당첨 번호를 입력해 주세요.");
			String winnersNumber = nextLine();
			System.out.println();
			return new Lotto(LottoNumber.of(winnersNumber.split(SPLITER)));
		}catch (NumberFormatException e){
			return inputWinnerLotto();
		}catch (IllegalArgumentException e){
			return inputWinnerLotto();
		}
	}

}