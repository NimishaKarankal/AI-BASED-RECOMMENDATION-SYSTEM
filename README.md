# AI-BASED-RECOMMENDATION-SYSTEM

#Project Details

**Name**: Nimisha Karankal  
**Company Name**: CODTECH IT SOLUTIONS  
**Intern ID**: CT08GJI  
**Domain**: Java Programming  
**Mentor**: Neela Santhosh  
**Batch Duration**: 25th December 2024 to 25th January 2025  

--
### **Overview of the Recommendation System Code** 

The **Recommendation System** is a Java application that leverages the **Apache Mahout** library to build a **user-based collaborative filtering** recommendation model. The system analyzes the behavior of users and generates personalized recommendations based on their preferences and the preferences of similar users. By using the **Pearson Correlation Similarity** measure, the system identifies similar users to make item suggestions. This type of recommendation system is typically used in platforms like e-commerce sites, music streaming services, and content-based applications.

The system works by reading user-item interaction data from a CSV file (`sample_data.csv`), calculates user similarity using Pearson correlation, identifies similar users within a neighborhood, and generates item recommendations for a specified user.

---

### **Features of the Recommendation System**

1. **User-Based Collaborative Filtering:**
   - The system uses a **user-based collaborative filtering** approach to recommend items to users based on the behavior and preferences of similar users.
   
2. **Pearson Correlation Similarity:**
   - The system uses the **Pearson Correlation** similarity metric to measure the degree of similarity between users. Pearson correlation is a statistical method to evaluate the linear relationship between two users' ratings or preferences.
   
3. **Data Model from CSV:**
   - The recommendation system loads user-item interaction data from a CSV file (`sample_data.csv`). This file typically contains ratings or interactions of users with items.
   
4. **User Neighborhood Calculation:**
   - The system creates a **user neighborhood** using the nearest neighbors (in this case, 2 neighbors). Users that are more similar are grouped together to make better recommendations.
   
5. **Item Recommendations:**
   - The system generates item recommendations for a specified user based on the behavior of similar users in the user neighborhood.

6. **Flexible and Scalable:**
   - The system can easily be adapted to work with larger datasets and different similarity measures (such as Cosine similarity or Tanimoto coefficient).
   
7. **Error Handling:**
   - The code includes exception handling to ensure that errors are caught and properly managed during the execution process.

8. **Console Output:**
   - After generating recommendations, the system prints out the recommended items for a specified user (in this case, user 1) along with their associated values.

---

### **About the Code**

The code is built using the **Apache Mahout** library, which is a powerful, scalable machine learning library for building recommendation systems, clustering algorithms, and other data mining applications. Here’s an overview of its functionality and components:

1. **DataModel Setup:**
   - The system first loads the user-item interaction data into a **DataModel** object, which is used to store the data in a way that is compatible with Mahout's algorithms. The `FileDataModel` class reads the data from a file (CSV in this case), which contains user ratings for different items.

2. **UserSimilarity:**
   - The **UserSimilarity** interface is implemented using the `PearsonCorrelationSimilarity` class. This class computes the similarity between users based on their ratings or interactions with items. The Pearson correlation measures how correlated two users’ preferences are with each other.

3. **UserNeighborhood:**
   - The system defines a **UserNeighborhood** using the `NearestNUserNeighborhood` class. This class selects a set of users (neighbors) that are most similar to a given user. In this case, it selects the 2 nearest users based on the Pearson correlation similarity.

4. **Recommender:**
   - The core of the recommendation system is the **Recommender** interface. The `GenericUserBasedRecommender` class implements this interface and generates recommendations for users based on the user similarity and the user neighborhood.
   
5. **Recommendation Generation:**
   - The system generates 3 recommendations for **user 1** by calling the `recommend()` method on the recommender object. This method returns a list of recommended items, each with an associated predicted rating or value.
   
6. **Result Output:**
   - After generating recommendations, the program prints the item IDs and their predicted values (ratings) for the specified user, providing insights into the most suitable items for that user.

---

### **Conclusion**
This **Recommendation System** is a basic implementation of a **user-based collaborative filtering** model using the **Apache Mahout** library. It demonstrates how to use similarity measures to recommend items based on the preferences of similar users. With minor modifications, this code can be extended to handle more sophisticated recommendation algorithms, larger datasets, and enhanced prediction accuracy.

# Output:
![image](https://github.com/user-attachments/assets/e4581ab9-97f5-461d-9ef3-cf0490b5adc2)
