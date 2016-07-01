package Main;

import javax.persistence.EntityManager;

import customTools.DBUtil;

public class ExampleTest {

	public static void main(String[] args) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		try {
			model.Account acc = em.find(model.Account.class, (long)1234);
			System.out.println(acc.getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
			System.out.println("Done!!");
		}

	}

}
