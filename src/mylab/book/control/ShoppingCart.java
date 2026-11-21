package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Publication;
import mylab.book.entity.Novel;
import mylab.book.entity.ReferenceBook;

import java.util.ArrayList;
import java.util.List;

/**
 * 출판물 관리 시스템에서 장바구니 기능을 구현한 ShoppingCart 클래스입니다.
 * 출판물(Publication)과 그 하위 클래스(Magazine, Novel, ReferenceBook)의 객체들을 장바구니에 추가하고 관리하는 기능을 제공합니다.
 */
public class ShoppingCart {

    private List<Publication> items;

    public ShoppingCart() {
        this.items=new ArrayList<>();
    }
    public void addItem(Publication item){
        items.add(item);
        System.out.println(item.getTitle()+"이(가) 장바구니에 추가되었습니다.");
    }
    public boolean removeItem(String title){
        for (int i=0;i<items.size(); i++){
            if (items.get(i).getTitle().equals(title)){
                Publication removed=items.remove(i);
                System.out.println(removed.getTitle()+"이(가) 장바구니에서 제거 되었습니다");
                return true;
            }
        }
        System.out.println("없어");
        return false;
    }
    public void displayCart(){
        for (int i=0; i<items.size();i++){
            Publication publication=items.get(i);
            System.out.println(publication);
        }

    }
    public int calculateTotalPrice(){
        int totalPrice=0;
        for (int i =0; i<items.size();i++){
            totalPrice+=items.get(i).getPrice();
        }
        return totalPrice;
    }
    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            // ManageBook과는 다른 할인율 적용 (용도별 차별화)
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9; // 10% 할인
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85; // 15% 할인
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8; // 20% 할인
            } else {
                total += item.getPrice(); // 기본 출판물은 할인 없음
            }
        }
        return total;
    }
    public void printStatistics() {
        int magazineCount = 0;
        int novelCount = 0;
        int referenceBookCount = 0; // instanceof를 활용한 타입별 카운팅
        for (Publication item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Novel) {
                novelCount++;
            } else if (item instanceof ReferenceBook) {
                referenceBookCount++;
            }
        }
        // 결과 출력
        System.out.println("====== 장바구니 통계 ======");
        System.out.println("잡지: " + magazineCount + "권");
        System.out.println("소설: " + novelCount + "권");
        System.out.println("참고서: " + referenceBookCount + "권");
        System.out.println("총 출판물: " + items.size() + "권"); }

    /**
     *
     * 마이크로소프트이(가) 장바구니에 추가되었습니다.
     * 경영과컴퓨터이(가) 장바구니에 추가되었습니다.
     * 빠삐용이(가) 장바구니에 추가되었습니다.
     * 남한산성이(가) 장바구니에 추가되었습니다.
     * 실용주의프로그래머이(가) 장바구니에 추가되었습니다.
     *
     */


    public static void main(String[] args) {
        ShoppingCart shoppingCart= new ShoppingCart();
        shoppingCart.addItem(new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"));
        shoppingCart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
        shoppingCart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
        shoppingCart.addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
        shoppingCart.addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));
        shoppingCart.displayCart();
        System.out.println("총가격:"+shoppingCart.calculateTotalPrice());
        System.out.println("할인적용가격:"+shoppingCart.calculateDiscountedPrice());
        shoppingCart.printStatistics();
        shoppingCart.removeItem("빠삐용");
        shoppingCart.displayCart();
        System.out.println("총가격:"+shoppingCart.calculateTotalPrice());
        System.out.println("할인적용가격:"+shoppingCart.calculateDiscountedPrice());



    }


}
