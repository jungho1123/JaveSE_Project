package mylab.book.control;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {
    /**
     * 출판물 배열을 분석하여 출판물 타입별 평균 가격을 계산합니다.
     * HashMap을 활용하여 각 타입별 총 가격과 개수를 기록합니다.
     * 각 출판물에 대해 타입을 확인하고(getPublicationType 메서드 사용), 해당 타입의 총 가격과 개수를 누적합니다.
     * getOrDefault 메서드를 사용하여 맵에 키가 없는 경우 기본값을 설정합니다.
     * 누적된 데이터를 바탕으로 타입별 평균 가격을 계산하여 새로운 맵에 저장하고 반환합니다.
     * @param publications
     * @return  타입별 평균 가격 계산 메서드
     */
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications){
        Map<String, Long> totalPrices=new HashMap<>();
        Map<String , Integer> counts=new HashMap<>();

        for (Publication publication : publications) {
            String type= getPublicationType(publication);
            totalPrices.put(type,totalPrices.getOrDefault(type,0L)+publication.getPrice());
            counts.put(type,counts.getOrDefault(type,0)+1);
        }
        Map<String,Double> avg= new HashMap<>();

        for(Map.Entry<String,Long> entry:totalPrices.entrySet()){
            String type= entry.getKey();
            Integer count= counts.get(type);
            Long totalPrice = entry.getValue();
            avg.put(type,avg.getOrDefault(type,totalPrice/(double)count));
        }
        return avg;



    }

    /**
     * 출판물 유형 분포 계산 메서드
     * 출판물 배열을 분석하여 각 타입별 비율(백분율)을 계산합니다.
     * 각 출판물의 타입을 확인하고, 타입별 개수를 HashMap에 기록합니다.
     * 전체 출판물 개수(배열 길이)를 기준으로 각 타입의 백분율을 계산합니다.
     * 계산된 백분율을 맵에 저장하여 반환합니다.
     * @param publications
     * @return
     */
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications){
        Map<String,Integer> counts= new HashMap<>();
        for (Publication publication : publications) {
            String type=getPublicationType(publication);
            counts.put(type,counts.getOrDefault(type,0)+1);


        }
        Map<String ,Double> distribution = new HashMap<>();
        for (Map.Entry<String,Integer> entry:counts.entrySet()){
            distribution.put(entry.getKey(),entry.getValue()*100.0/publications.length);
        }
        return distribution;


    }

    /**
     * 특정 연도 출판물 비율 계산 메서드
     * 입력 받은 연도에 출판된 출판물의 비율을 계산합니다.
     * 각 출판물의 출판일자에서 연도 부분(처음 4자리)을 추출하여 지정된 연도와 일치하는지 확인합니다.
     * 일치하는 출판물의 개수를 세어 전체 대비 백분율을 계산하고 반환합니다.
     * 출판일자 형식은 "yyyy-mm-dd"로 가정합니다.
     * @param publications
     * @param year
     * @return
     */
    public double calculatePublicationRatioByYear(Publication[] publications, String year){
        int cnt=0;
        for (Publication publication : publications) {
            if(publication.getPublishDate().substring(0,4).equals(year)){
                cnt++;
            }

        }
        return cnt*100.0/publications.length;

    }

    /**
     * 출판물 타입 확인 헬퍼 메서드
     * @param pub
     * @return
     * 출판물 객체의 실제 타입을 확인하여 해당하는 한글 타입명을 반환합니다.
     * instanceof 연산자를 사용하여 객체 타입을 확인합니다:
     * Novel 타입: "소설" 반환
     * Magazine 타입: "잡지" 반환
     * ReferenceBook 타입: "참고서" 반환
     * 그 외: "기타" 반환
     */
    private String getPublicationType(Publication pub){
        if (pub instanceof Novel){
            return "소설";
        } else if (pub instanceof  Magazine) {
            return "잡지";

        } else if (pub instanceof ReferenceBook) {
            return "참고서";

        }
        return "기타";
    }

    /**
     * 통계 정보 출력 메서드
     * @param publications
     * 다양한 통계 메서드를 호출하여 출판물에 대한 종합적인 통계 정보를 출력합니다.
     * DecimalFormat을 사용하여 숫자 값을 보기 좋은 형식으로 포맷팅합니다("#,###.##" 패턴 사용).
     * 출력하는 통계 정보:
     * 타입별 평균 가격
     * 출판물 유형 분포(백분율)
     * 2007년도에 출판된 출판물 비율
     */
    public void printStatistics(Publication[] publications){
        DecimalFormat format=new DecimalFormat("#,###.##");
        System.out.println("===타입별 평균 가격===");
        for (Map.Entry<String,Double> entry:calculateAveragePriceByType(publications).entrySet()){
            System.out.println(entry.getKey()+":"+format.format(entry.getValue())+"원");
        }
        System.out.println("===출판물 유형 분포===");
        for (Map.Entry<String,Double> entry:calculatePublicationDistribution(publications).entrySet()){
            System.out.println(entry.getKey()+":"+format.format(entry.getValue())+"%");
        }
        double ratioByYear=calculatePublicationRatioByYear(publications,"2007");
        System.out.println("2007년도에 출판된 비율:"+format.format(ratioByYear)+"%");
    }





}
