package com.example.wespotbackend.feed;

import com.example.wespotbackend.feed.dto.FeedResponse;
import com.example.wespotbackend.user.dto.UserResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.wespotbackend.feed.QFeed.feed;
import static com.example.wespotbackend.user.QUser.user;

@Repository
class FeedRepositoryCustomImpl implements FeedRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public FeedRepositoryCustomImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<FeedResponse> paginationNoOffset(Long lastFeedId, int pageSize) {
        return queryFactory.
                select(Projections.fields(FeedResponse.class,
                        feed.id.as("id"),
                        feed.user,
                        feed.title,
                        feed.content,
                        feed.createdAt,
                        feed.modifiedAt
                        ))
                .from(feed)
                .innerJoin(feed.user, user)
                .where(
                        loeFeedId(lastFeedId)
                )
                .orderBy(feed.id.desc())
                .limit(pageSize)
                .fetch();
    }

    private BooleanExpression loeFeedId(Long feedId) {
        if (feedId == null) {
            return null;
        }

        return feed.id.loe(feedId);
    }
}
