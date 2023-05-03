package org.example;

class MyProgram{
    private SearchButton searchButton = new SearchButton(this);

    public void setModeAll(){
        searchButton.setSearchStrategy(new SearchStrategyAll());
    }
    public void setModeImage(){
        searchButton.setSearchStrategy(new SearchStrategyImage());
    }
    public void setModeNews(){
        searchButton.setSearchStrategy(new SearchStrategyNews());
    }
    public void setModeMap(){
        searchButton.setSearchStrategy(new SearchStrategyMap());
    }

    //...AdapterPattern

    public void setModeMovie () {
        searchButton.setSearchStrategy(
                new SearchFindAdapter(new FindMovieAltorithm())
        );
    }

    public void testProgram(){
        searchButton.onClick();
        setModeImage();
        searchButton.onClick();
        setModeNews();
        searchButton.onClick();
        setModeMap();
        searchButton.onClick();
    }
}

interface FindAlgorithm {
    public void find (boolean global);
}

class FindMovieAlgorithm implements FindAlgorithm {
    public void find (boolean global) {
        System.out.println(
                "find movie" + (global ? " globally" : "")
        );
    }
}

interface SearchStrategy{
    public void search();
}

class SearchStrategyAll implements SearchStrategy{
    public void search(){
        System.out.println("search All");
    }
}
class SearchStrategyImage implements SearchStrategy{
    public void search(){
        System.out.println("search Image");
    }
}

class SearchStrategyNews implements SearchStrategy{
    public void search(){
        System.out.println("search News");
    }
}

class SearchStrategyMap implements SearchStrategy{
    public void search(){
        System.out.println("search Map");
    }
}

//AdapterPattern
class SearchFindAdapter implements SearchStrategy {
    private FindAlgorithm findAlgorithm;

    public SearchFindAdapter (FindAlgorithm _findAlgorithm) {
        findAlgorithm = _findAlgorithm;
    }
    public void search () {
        findAlgorithm.find(true);
    }
}

class SearchButton {

    private MyProgram myProgram;

    public SearchButton (MyProgram _myProgram) {
        myProgram = _myProgram;
    }

    private SearchStrategy searchStrategy = new SearchStrategyAll();

    public void setSearchStrategy (SearchStrategy _searchStrategy) {
        searchStrategy = _searchStrategy;
    }

    public void onClick () {
        searchStrategy.search();
    }
}

public class Main {
    public static void main(String[] args) {
        MyProgram myProgram = new MyProgram();
        myProgram.testProgram();
    }
}

