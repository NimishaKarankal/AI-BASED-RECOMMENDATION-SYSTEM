package com.example;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            DataModel dataModel = new FileDataModel(new File("sample_data.csv"));
            UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, dataModel);

            Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
            List<RecommendedItem> recommendations = recommender.recommend(1, 3);

            System.out.println("Recommendations for user 1:");
            for (RecommendedItem recommendation : recommendations) {
                System.out.println("Item: " + recommendation.getItemID() + ", Value: " + recommendation.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Executed Successfully...");
    }
}
