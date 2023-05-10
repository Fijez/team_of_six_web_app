package team.of.six.firstwebapp.utils;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface PageableUtils
{
  default Long getPageLimit(Long pageSize) {
    var limit = Optional.ofNullable(pageSize).orElse(10L);

    return limit == 0L ? 10L : limit;
  }

  default Long getPageIndex(Long pageIndex) {
    if (pageIndex != null) {
      return pageIndex == 0 ? pageIndex : pageIndex - 1;
    }

    return 0L;
  }

  default Pageable getPageableWithSortById(Long pageSize, Long pageIndex) {

    Long limitP = getPageLimit(pageSize);
    pageIndex = getPageIndex(pageIndex);
    Sort sort = Sort.by("id");
    return PageRequest.of(pageIndex.intValue(), limitP.intValue(), sort);
  }

  default Pageable getPageableWithSort(Long pageSize, Long pageIndex, Sort sort) {
    Long limitP = getPageLimit(pageSize);
    pageIndex = getPageIndex(pageIndex);

    return PageRequest.of(pageIndex.intValue(), limitP.intValue(), sort);
  }
}
