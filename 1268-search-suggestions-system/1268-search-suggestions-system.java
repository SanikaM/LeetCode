class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> finalResult = new ArrayList<>();
        if(products == null || products.length == 0 || searchWord == null || searchWord.length() == 0)
            return finalResult;
        
        Arrays.sort(products);
        List<String> possibleProducts = new ArrayList<>();
        for(String prod : products){
            possibleProducts.add(prod);
        }
        
        for(int i=0;i<searchWord.length();i++) {
            char c = searchWord.charAt(i);
            List<String> filteredProducts = new ArrayList<>();
            for(String product : possibleProducts) {
                if(i<product.length() && c == product.charAt(i))
                {
                    filteredProducts.add(product);
                }
            }
            
            List<String> tempResults = new ArrayList<>();
            for(int j=0;j<3 && j< filteredProducts.size() ;j++)
                tempResults.add(filteredProducts.get(j));
            
            finalResult.add(tempResults);
            
            possibleProducts = filteredProducts;
        }
        
        return finalResult;
    }
}