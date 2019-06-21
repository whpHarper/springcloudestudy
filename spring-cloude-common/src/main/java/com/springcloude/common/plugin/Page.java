package com.springcloude.common.plugin;

import java.io.Serializable;

/**
 * @author merlin
 * @create 2018-05-22 下午6:06
 */
public class Page implements Serializable {
  private static final long serialVersionUID = 2439137595310411068L;
  public static final int INITED_CURRENT_PAGE = 1;
  public static final int DEFAULT_MAX_RESULTS = 20;
  public static final int DEFAULT_PAGING_LINKS = 10;
  public static final int PAGING_LINKS_STYLE_STATIC = 0;
  public static final int PAGING_LINKS_STYLE_DYNAMIC = 1;
  private boolean inited = false;
  private int currentPage = INITED_CURRENT_PAGE;
  private int maxResults = DEFAULT_MAX_RESULTS;
  private int pagingLinks = DEFAULT_PAGING_LINKS;
  private int pagingLinksStyle = PAGING_LINKS_STYLE_STATIC;
  private int totalResults = 0;
  private String name;
  private Long userId;
  private long currentTotalResults=200;
  private String serverType;

  public String getServerType() {
    return serverType;
  }

  public void setServerType(String serverType) {
    this.serverType = serverType;
  }

  public long getCurrentTotalResults() {
    return currentTotalResults;
  }

  public void setCurrentTotalResults(long currentTotalResults) {
    this.currentTotalResults = currentTotalResults;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Page() {
    this(DEFAULT_MAX_RESULTS, DEFAULT_PAGING_LINKS, PAGING_LINKS_STYLE_STATIC);
  }

  public Page(int maxResults) {
    this(maxResults, DEFAULT_PAGING_LINKS, PAGING_LINKS_STYLE_STATIC);
  }

  public Page(int maxResults, int pagingLinks) {
    this(maxResults, pagingLinks, PAGING_LINKS_STYLE_STATIC);
  }

  public Page(int maxResults, int pagingLinks, int pagingLinkStyle) {
    if (maxResults < 1) {
      throw new IllegalArgumentException("maxResults must not smaller than 1 but " + maxResults);
    }
    if (pagingLinks < 1) {
      throw new IllegalArgumentException("pagingLinks must not smaller than 1 but " + pagingLinks);
    }
    if (pagingLinkStyle != PAGING_LINKS_STYLE_STATIC && pagingLinkStyle != PAGING_LINKS_STYLE_DYNAMIC) {
      throw new IllegalArgumentException("pagingLinkStyle must be " + PAGING_LINKS_STYLE_STATIC + " or " + PAGING_LINKS_STYLE_DYNAMIC + " but " + pagingLinkStyle);
    }
    this.maxResults = maxResults;
    this.pagingLinks = pagingLinks;
    this.pagingLinksStyle = pagingLinkStyle;
  }

  public int getFirstResult() {
    return Math.max((getCurrentPage() - 1) * maxResults, 0);
  }

  public int getFirstRownum() {
    return getFirstResult() + 1;
  }

  public int getLastRownum() {
    return getFirstResult() + maxResults;
  }

  public int getFirstPage() {
    return Math.min(totalResults, 1);
  }

  public int getCurrentResultNum() {
    return getTotalResults() - ((getCurrentPage() - 1) * getMaxResults());
  }

  public int getLastPage() {
    return (int) Math.ceil((double) totalResults / maxResults);
  }

  public int getStartPagingLink() {
    if (pagingLinksStyle == PAGING_LINKS_STYLE_DYNAMIC) {
      return Math.max(getCurrentPage() - pagingLinks, getFirstPage());
    }
    return (getCurrentPage() - 1) / pagingLinks * pagingLinks + 1;
  }

  public int getEndPagingLink() {
    if (pagingLinksStyle == PAGING_LINKS_STYLE_DYNAMIC) {
      return Math.min(getCurrentPage() + pagingLinks, getLastPage());
    }
    return Math.min(getStartPagingLink() + pagingLinks - 1, getLastPage());
  }

  public int getTotalPage() {
    int totalPage = getTotalResults() / getMaxResults();
    if (totalPage == 0 || getTotalResults() % getMaxResults() != 0) {
      totalPage++;
    }
    return totalPage;
  }

  public int getPrelinkPage() {
    return Math.max(getCurrentPage() - 1, getFirstPage());
  }

  public int getPostlinkPage() {
    return Math.min(getCurrentPage() + 1, getLastPage());
  }

  public int getCurrentPage() {
    if (isInited()) {
      return Math.min(currentPage, getLastPage());
    } else {
      return currentPage;
    }
  }

  public void setCurrentPage(int currentPage) {
    if (currentPage < 1) {
      return;
    }
    this.currentPage = currentPage;
  }

  public int getMaxResults() {
    return maxResults;
  }

  public void setMaxResults(int maxResults) {
    if (maxResults < 1) {
      return;
    }
    this.maxResults = maxResults;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(int totalResults) {
    this.totalResults = totalResults;
    this.inited = true;
  }

  public int getPagingLinks() {
    return pagingLinks;
  }

  protected void setPagingLinks(int pagingLinks) {
    if (pagingLinks < 1) {
      return;
    }
    this.pagingLinks = pagingLinks;
  }

  public int getPagingLinksStyle() {
    return pagingLinksStyle;
  }

  public void setPagingLinksStyle(int pagingLinksStyle) {
    if (pagingLinksStyle != PAGING_LINKS_STYLE_STATIC && pagingLinksStyle != PAGING_LINKS_STYLE_DYNAMIC) {
      return;
    }
    this.pagingLinksStyle = pagingLinksStyle;
  }

  public boolean isInited() {
    return inited;
  }

  public void setInited(boolean inited) {
    this.inited = inited;
  }

  @Override
  public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode()) + "(" + "firstPage=" + "'" + getFirstPage() + "'" + ", " + "lastPage=" + "'" + getLastPage() + "'" + ", " + "currentPage=" + "'" + getCurrentPage() + "'" + ", " + "startPagingLink=" + "'" + getStartPagingLink() + "'" + ", " + "endPagingLink=" + "'" + getEndPagingLink() + "'" + ")";
  }
}
