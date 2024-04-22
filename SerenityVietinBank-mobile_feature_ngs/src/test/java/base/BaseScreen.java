package base;

import com.jayway.jsonpath.JsonPath;
import java.io.File;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import utils.keywords.MobileUI;

public class BaseScreen {

  private static final String OBJECT_REPO_PATH = System.getProperty("user.dir") + File.separator + "object repo" + File.separator;

  private String repoName;

  protected MobileUI mobileUI;

  public BaseScreen(MobileUI mobileUI) {
    this.mobileUI = mobileUI;
  }

  private String getRepoName() {
    return repoName;
  }

  public void setRepoName(String repoName) {
    this.repoName = repoName;
  }

  public String getXpathOfElement(String elementName) {
    String repoFilePath;
    if(mobileUI.getPlatformName().toUpperCase().equals("ANDROID")) {
      repoFilePath = OBJECT_REPO_PATH + File.separator + "android" + File.separator + getRepoName() + ".json";
    } else {
      repoFilePath = OBJECT_REPO_PATH + File.separator + "ios" + File.separator + getRepoName() + ".json";
    }
    try {
      return JsonPath.read(new File(repoFilePath), "$." + elementName).toString();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String getXpathOfElementWithParam(String elementName, String paramName) {
    String repoFilePath;
    if(mobileUI.getPlatformName().toUpperCase().equals("ANDROID")) {
      repoFilePath = OBJECT_REPO_PATH + File.separator + "android" + File.separator + getRepoName() + ".json";
    } else {
      repoFilePath = OBJECT_REPO_PATH + File.separator + "ios" + File.separator + getRepoName() + ".json";
    }
    try {
      String xpath = JsonPath.read(new File(repoFilePath), "$." + elementName).toString();
      return StringUtils.replace(xpath, "{param}", paramName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
