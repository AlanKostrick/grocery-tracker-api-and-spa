package org.wecancodeit.serverside.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.serverside.models.PopularItem;

public interface PopularItemRepository extends CrudRepository<PopularItem, Long> {
}
