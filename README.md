http://wiki.fasterxml.com/JacksonInFiveMinutes

Jackson offers three alternative methods (one with two variants) for processing JSON:

Streaming API
(aka "Incremental parsing/generation") reads and writes JSON content as discrete events.
org.codehaus.jackson.JsonParser reads, org.codehaus.jackson.JsonGenerator writes.
Inspired by the StAX API.

Tree Model
provides a mutable in-memory tree representation of a JSON document.
org.codehaus.jackson.map.ObjectMapper can build trees; trees consist of JsonNode nodes.
The tree model is similar to the XML DOM.

Data Binding
converts JSON to and from POJOs based either on property accessor conventions or annotations.
There are two variants: simple and full data binding
Simple data binding means converting to and from Java Maps, Lists, Strings, Numbers, Booleans and nulls
Full data binding means converting to and from any Java bean type (as well as "simple" types mentioned above)
org.codehaus.jackson.map.ObjectMapper performs the marshalling (writing JSON) and unmarshalling (reading JSON) for both variants.
Inspired by the annotation-based (code-first) variant of JAXB.
From usage perspective, one way to summarize these 3 methods is:

Streaming API is best performing (lowest overhead, fastest read/write; other 2 methods build on it)
Data Binding is often most convenient
Tree Model is most flexible

