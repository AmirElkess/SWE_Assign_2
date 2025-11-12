## This file documents some of the potential bugs in RingBuffer class implementation

- the constructor doesn't check the capacity for larger than zero, meaning the user can input non-positive value for the capacity.
- Another possible logical error, is that the iterator starts at index 0, regardless of where the start of the ring buffer is, which is ok as long as the buffer hasn't wrapped around, but once it has, the iterator will not return the elements in the correct order.