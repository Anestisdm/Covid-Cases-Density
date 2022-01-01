---
<p align="center">
<img src="https://user-images.githubusercontent.com/72802400/147390953-1710cda5-3ec6-48bb-9e9a-545ed4f917ee.jpg" align="center"><img src="https://user-images.githubusercontent.com/72802400/147390801-6d7ec12e-b95a-4462-9816-05e6d87af24a.jpg" width ="90" height"100" align = "center">
</p>

---

# Covid Cases Density

### 1 - Scope
The purpose of this project is to implement a sorting algorithm with Priority Queues so that it can be used to find the cities with the highest density of covid
cases.

### 2 - Application *Covid_k*
The application will read the daily covid cases report from  a text file. Then, it will ask the user for the parameter k that represents the number of the cities that user want to print. Lastly, the application will print the top k cities with higher cases numbers per 50,000 citizens. The application implemented with custom Priority Queue.

### 3 - Application *DynamicCovid_k_withPQ*
Same as the previous application with only difference that in the Priority Queue retain only the k cities with higher cases numbers per 50,000 citizens every time the application reads a new single line from the text file. This means that we do not keep data in the Priority Queue that we do not need.

### 4 - Application *Dynamic_Median*
In this application we read an input file again in the same format, and we are interested in answering questions like: “How much
high cases density a city needs to have to be in the top 50% of cities we are looking at? " (to enter a yellow zone e.g.). This means that we calculate the median from the covid case densities we have.

### 5 - How it works

**Workstation Specifications**
- Windows 10 or Linux or MacOS, 64 bit
- RAM, 8GB required
- 128 GB Storage 
- 4 Core CPU

**Steps to run the application**
1. Clone this repository to Intellij
3. Run 'Covid_k' or 'DynamicCovid_k_withPQ' or 'Application *Dynamic_Median' from Intellij to create configurations
4. Go to edit configurations on the application you want to run
5. Add in the program arguments the following: 'src/Data/InputFile.txt'
6. Run the application you want to run
7. Start using the application and all the features from UI that appears


![image](https://user-images.githubusercontent.com/72802400/147856923-d8a6b059-c919-4b68-8dcf-19d86a2e60c7.png)


### 6 - User Support
For help or new feature suggestions you can contanct with the development team.
