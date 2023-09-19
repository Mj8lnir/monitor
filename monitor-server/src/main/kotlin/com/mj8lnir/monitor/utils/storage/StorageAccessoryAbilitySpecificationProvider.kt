package com.mj8lnir.monitor.utils.storage

import com.mj8lnir.monitor.model.storage.Storage
import com.mj8lnir.monitor.model.storage.StorageColumn
import com.mj8lnir.monitor.utils.SpecificationProvider
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

@Component
class StorageAccessoryAbilitySpecificationProvider : SpecificationProvider<Storage> {

    override fun getSpec(input: String): Specification<Storage> {
        val bool = try {
            input.toBoolean()
        } catch (e: Exception) {
            return Specification.where(null)
        }
        return Specification { root: Root<Storage>, _: CriteriaQuery<*>?, builder: CriteriaBuilder ->
            builder.equal(root.get<Boolean>(StorageColumn.ACCESSORY_ABILITY.fieldName), bool)
        }
    }
}