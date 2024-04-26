package jp.ex.test;

import jp.ex.entity.User;
import jp.ex.exception.UserException;

public class UserTest {

	public static void main(String[] args) {

		// Test結果
		boolean result = true;

		System.out.println("--- Test開始 ---");

		// Test1:正常系（ユーザ作成）
		User suzuki = null;
		try {
			suzuki = User.createUser("Suzuki", "test@test.com", "password");
			System.out.println("Test1:OK");
		} catch (UserException e) {
			result = false;
			System.out.println("Test1:NG");
		}

		// Test2:異常系（ユーザ作成_ユーザ名が重複しているケース）
		try {
			User nomura = User.createUser("Suzuki", "test@test.com", "password");

			result = false;
			System.out.println("Test2:NG");
		} catch (UserException e) {
			if (!e.getMessage().equals("指定のユーザ名は既に使用されています。")) {
				result = false;
				System.out.println("Test2:NG");
			} else {
				System.out.println("Test2:OK");
			}
		}

		// Test3:異常系（ユーザ作成_ユーザ名が空のケース）
		try {
			User takahashi = User.createUser("", "test@test.com", "password");

			result = false;
			System.out.println("Test3:NG");
		} catch (UserException e) {
			if (!e.getMessage().equals("名前、メールアドレス、パスワードのいずれかが空です。")) {
				result = false;
				System.out.println("Test3:NG");
			} else {
				System.out.println("Test3:OK");
			}
		}

		// Test4:異常系（ユーザ作成_メールアドレスが空のケース）
		try {
			User kato = User.createUser("Kato", "", "password");

			result = false;
			System.out.println("Test4:NG");
		} catch (UserException e) {
			if (!e.getMessage().equals("名前、メールアドレス、パスワードのいずれかが空です。")) {
				result = false;
				System.out.println("Test4:NG");
			} else {
				System.out.println("Test4:OK");
			}
		}

		// Test5:異常系（ユーザ作成_パスワードが空のケース）
		try {
			User sato = User.createUser("Sato", "test@test.com", "");

			result = false;
			System.out.println("Test5:NG");
		} catch (UserException e) {
			if (!e.getMessage().equals("名前、メールアドレス、パスワードのいずれかが空です。")) {
				result = false;
				System.out.println("Test5:NG");
			} else {
				System.out.println("Test5:OK");
			}
		}

		/*
		 * 下記のコードは課題2に取り組む際にコメントアウトを解除してください。
		 */

//		// Test6:正常系（ログイン）
//		try {
//			suzuki.login("test@test.com", "password");
//			System.out.println("Test6:OK");
//		} catch (UserException e) {
//			result = false;
//			System.out.println("Test6:NG");
//		}
//
//		// Test7:正常系（ログアウト）
//		try {
//			suzuki.logout();
//			System.out.println("Test7:OK");
//		} catch (UserException e) {
//			result = false;
//			System.out.println("Test7:NG");
//		}
//
//		// Test8:異常系（ログイン_メールアドレスとパスワードが空のケース）
//		try {
//			suzuki.login("", "");
//
//			result = false;
//			System.out.println("Test8:NG");
//		} catch (UserException e) {
//			if (!e.getMessage().equals("メールアドレス、またはパスワードが間違っています。")) {
//				result = false;
//				System.out.println("Test8:NG");
//			} else {
//				System.out.println("Test8:OK");
//			}
//		}
//
//		// Test9:異常系（ログイン_パスワードが空のケース）
//		try {
//			suzuki.login("test@test.com", "");
//
//			result = false;
//			System.out.println("Test9:NG");
//		} catch (UserException e) {
//			if (!e.getMessage().equals("メールアドレス、またはパスワードが間違っています。")) {
//				result = false;
//				System.out.println("Test9:NG");
//			} else {
//				System.out.println("Test9:OK");
//			}
//		}
//
//		// Test10:異常系（ログイン_メールアドレスが空のケース）
//		try {
//			suzuki.login("", "password");
//
//			result = false;
//			System.out.println("Test10:NG");
//		} catch (UserException e) {
//			if (!e.getMessage().equals("メールアドレス、またはパスワードが間違っています。")) {
//				result = false;
//				System.out.println("Test10:NG");
//			} else {
//				System.out.println("Test10:OK");
//			}
//		}
//
//		// Test11:異常系（ログイン_パスワードが誤っているケース）
//		try {
//			suzuki.login("test@test.com", "pass");
//
//			result = false;
//			System.out.println("Test11:NG");
//		} catch (UserException e) {
//			if (!e.getMessage().equals("メールアドレス、またはパスワードが間違っています。")) {
//				result = false;
//				System.out.println("Test11:NG");
//			} else {
//				System.out.println("Test11:OK");
//			}
//		}
//
//		// Test12:異常系（ログイン_メールアドレスが誤っているケース）
//		try {
//			suzuki.login("test@test", "password");
//
//			result = false;
//			System.out.println("Test12:NG");
//		} catch (UserException e) {
//			if (!e.getMessage().equals("メールアドレス、またはパスワードが間違っています。")) {
//				result = false;
//				System.out.println("Test12:NG");
//			} else {
//				System.out.println("Test12:OK");
//			}
//		}
//
//		// Test13:異常系（ログイン_二重ログインのケース）
//		try {
//			suzuki.login("test@test.com", "password");
//			suzuki.login("test@test.com", "password");
//
//			result = false;
//			System.out.println("Test13:NG");
//		} catch (UserException e) {
//			if (!e.getMessage().equals("すでにログインしています。")) {
//				result = false;
//				System.out.println("Test13:NG");
//			} else {
//				System.out.println("Test13:OK");
//			}
//		}
//
//		// Test14:異常系（ログアウト_二重ログアウトのケース）
//		try {
//			suzuki.logout();
//			suzuki.logout();
//
//			result = false;
//			System.out.println("Test14:NG");
//		} catch (UserException e) {
//			if (!e.getMessage().equals("すでにログアウト済みです。")) {
//				result = false;
//				System.out.println("Test14:NG");
//			} else {
//				System.out.println("Test14:OK");
//			}
//		}

		if (result) {
			System.out.println("Test結果：OK");
		} else {
			System.out.println("Test結果：NG");
		}
		System.out.println("--- Test終了 ---");
	}
}
