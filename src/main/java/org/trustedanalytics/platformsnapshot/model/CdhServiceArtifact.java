/**
 * Copyright (c) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.trustedanalytics.platformsnapshot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.trustedanalytics.platformsnapshot.client.cdh.entity.CdhService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Data
@Table(name = "CDH_SERVICE_ARTIFACT")
@NoArgsConstructor
@Entity
public class CdhServiceArtifact implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SNAPSHOT_ID")
    @JsonIgnore
    private PlatformSnapshot snapshot;
    @Column(name="NAME")
    private String name;
    @Column(name="TYPE")
    private String type;
    @Column(name="SERVICE_STATE")
    private String serviceState;
    @Column(name="HEALTH_SUMMARY")
    private String healthSummary;
    @Column(name="ENTITY_STATUS")
    private String entityStatus;

    public CdhServiceArtifact(CdhService cdhService) {
        this.name = cdhService.getName();
        this.type = cdhService.getType();
        this.serviceState = cdhService.getServiceState();
        this.healthSummary = cdhService.getHealthSummary();
        this.entityStatus = cdhService.getEntityStatus();
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        } else if(other == null) {
            return false;
        } else if(!other.getClass().equals(CdhServiceArtifact.class)) {
            return false;
        }

        return Objects.equals(name, ((CdhServiceArtifact) other).name);
    }

    @Override
    public int hashCode() { return Objects.hashCode(name); }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("type", type)
                .add("serviceState", serviceState)
                .add("healthSummary", healthSummary)
                .add("entityStatus", entityStatus)
                .toString();
    }
}
