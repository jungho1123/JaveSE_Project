package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Long> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (Publication publication : publications) {
            String type = getPublicationType(publication);
            totalPrices.put(type, totalPrices.getOrDefault(type, 0L) + publication.getPrice());
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> averages = new HashMap<>();
        for (Map.Entry<String, Long> entry : totalPrices.entrySet()) {
            String type = entry.getKey();
            averages.put(type, entry.getValue() / (double) counts.get(type));
        }
        return averages;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<>();
        for (Publication publication : publications) {
            String type = getPublicationType(publication);
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            distribution.put(entry.getKey(), entry.getValue() * 100.0 / publications.length);
        }
        return distribution;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        if (publications.length == 0) {
            return 0.0;
        }

        int count = 0;
        for (Publication publication : publications) {
            String publicationYear = publication.getPublishDate().substring(0, 4);
            if (publicationYear.equals(year)) {
                count++;
            }
        }
        return count * 100.0 / publications.length;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        }
        if (pub instanceof Magazine) {
            return "잡지";
        }
        if (pub instanceof ReferenceBook) {
            return "참고서";
        }
        return "기타";
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat format = new DecimalFormat("#,###.##");

        System.out.println("==== 타입별 평균 가격 ====");
        for (Map.Entry<String, Double> entry : calculateAveragePriceByType(publications).entrySet()) {
            System.out.println(entry.getKey() + ": " + format.format(entry.getValue()) + "원");
        }

        System.out.println("==== 출판물 유형 분포 ====");
        for (Map.Entry<String, Double> entry : calculatePublicationDistribution(publications).entrySet()) {
            System.out.println(entry.getKey() + ": " + format.format(entry.getValue()) + "%");
        }

        double ratioByYear = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("2007년도에 출판된 출판물 비율: " + format.format(ratioByYear) + "%");
    }
}
