package com.searchmodule;

import com.searchmodule.pages.SearchPage;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {


    @Test
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.gotTo();
        searchPage.doSearch(keyword);
        searchPage.gotToVideos();
        int size = searchPage.getResult();
        Assert.assertTrue(size> 0);
    }

}
