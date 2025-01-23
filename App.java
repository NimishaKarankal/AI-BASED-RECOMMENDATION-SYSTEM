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

/*
 * A simple recommendation system using Apache Mahout.
 * This program gives personalized recommendations for a use based on what similar users liked. 
 */
public class App {
    public static void main(String[] args) {
        try {
            // First, we load the data from a file.
            // The file should contain user-item preferences, like:
            // userId,itemId,preference (e.g., 1,104,4.5)
            DataModel dataModel = new FileDataModel(new File("sample_data.csv"));

            // Now, let's figure out how similar users are to each other.
            // We'll use Pearson Correlation to measure that similarity.
            UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);

            // Once we know how similar users are, we create a "neighborhood."
            // This is basically a group of users who are closest (most similar) to the target user.
            // Here, we're picking the 2 most similar users.
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, dataModel);

            // Time to build the recommender system! 
            // This will use the similarity and neighborhood info we just calculated.
            Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);

            // Let's get some recommendations for user with ID = 1.
            // We're asking for the top 3 recommendations.
            List<RecommendedItem> recommendations = recommender.recommend(1, 3);

            // Show the recommendations to the user.
            System.out.println("Recommendations for user 1:");
            for (RecommendedItem recommendation : recommendations) {
                // Each recommendation has an item ID and a "value" that shows how strong the recommendation is.
                System.out.println("Item: " + recommendation.getItemID() + ", Value: " + recommendation.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Executed Successfully...");
    }
}
