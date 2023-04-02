package com.digitalbooking.back.management.features.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    @Query("SELECT feature FROM Feature feature WHERE feature.id IN (:feature_ids)")
    Set<Feature> findFeaturesByIds(@Param("feature_ids") Set<Long> feature_ids);
}
