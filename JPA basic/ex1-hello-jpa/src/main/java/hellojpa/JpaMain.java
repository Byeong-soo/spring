package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 비영속
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");
            // 영속
            em.persist(member1);
            em.persist(member2);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

//        try {
//
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }
//
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }
//

//        try {
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }

        emf.close();
    }
}
