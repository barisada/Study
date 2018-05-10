### WRITE READOBJECT METHODS DEFENSIVELY

- when writing readObject method, adopt mind-set that it is like writing public constructor.
- Do not assume that the byte stream represents an actual serialized instance.
- For classes with object reference fields that must remain private, defensively copy each object in such a field. Mutable components of immutable classes fall  into this category.
-  Check any invariants and throw an InvalidObjectException if a check fails. The checks should follow any defensive copying.
-  If an entire object graph must be validated after it is deserialized, use the
  ObjectInputValidation interface [JavaSE6, Serialization].
-  Do not invoke any overridable methods in the class, directly or indirectly.