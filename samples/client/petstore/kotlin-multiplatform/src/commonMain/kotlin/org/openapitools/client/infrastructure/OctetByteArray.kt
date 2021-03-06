package org.openapitools.client.infrastructure

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor

@Serializable
class OctetByteArray(val value: ByteArray) {
    @Serializer(OctetByteArray::class)
    companion object : KSerializer<OctetByteArray> {
        override val descriptor = StringDescriptor.withName("OctetByteArray")
        override fun serialize(encoder: Encoder, obj: OctetByteArray) = encoder.encodeString(hex(obj.value))
        override fun deserialize(decoder: Decoder) = OctetByteArray(hex(decoder.decodeString()))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as OctetByteArray
        return value.contentEquals(other.value)
    }

    override fun hashCode(): Int {
        return value.contentHashCode()
    }

    override fun toString(): String {
        return "OctetByteArray(${hex(value)})"
    }
}