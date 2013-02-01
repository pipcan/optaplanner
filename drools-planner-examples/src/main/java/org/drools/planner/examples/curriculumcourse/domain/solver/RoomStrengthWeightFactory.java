/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.planner.examples.curriculumcourse.domain.solver;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.drools.planner.core.heuristic.selector.common.decorator.SelectionSorterWeightFactory;
import org.drools.planner.examples.curriculumcourse.domain.CurriculumCourseSchedule;
import org.drools.planner.examples.curriculumcourse.domain.Room;

public class RoomStrengthWeightFactory implements SelectionSorterWeightFactory<CurriculumCourseSchedule, Room> {

    public Comparable createSorterWeight(CurriculumCourseSchedule schedule, Room room) {
        return new RoomStrengthWeight(room);
    }

    public static class RoomStrengthWeight implements Comparable<RoomStrengthWeight> {

        private final Room room;

        public RoomStrengthWeight(Room room) {
            this.room = room;
        }

        public int compareTo(RoomStrengthWeight other) {
            return new CompareToBuilder()
                    .append(room.getCapacity(), other.room.getCapacity())
                    .append(room.getId(), other.room.getId())
                    .toComparison();
        }

    }

}
