# Yatzy-Refactoring-Kata

This is a refactoring exercice with base on :
https://github.com/emilybache/Yatzy-Refactoring-Kata

We will try to changed the Yatzy implementation to make it more efficient and consistent.

This is one implementation of the Yatzy game https://en.wikipedia.org/wiki/Yahtzee

There is a main class in src/main/java ( might be better to create a package).
There is a Junit test class in src/test/java containing 16 tests.

In this implementation, for a given roll there will be only 5 dice.
In this implementation, each die can be between one and six.

For further development, we could for example change the number of allowed dice.
For example, the method "ones()" with a roll than contains 10 dice with 7 being "1" would return 7 with no need to change this particular method.
Most of the methods could handle a roll with different number ( than 5) with no change.

If we want to change the higher bound (for example with a die with 10 faces) we would need to add extra methods (categories) but the existing will still work.

nOfAKind, generateFrequencyArray, scoreCompteWithProvidedNumber are three private methods that have been added to avoid code duplication since they have no business value they are private and hence not tested.

For the method checkValidity, if we were to use Aspects, it would be better.
We could use Spring Aspect but this would be overkill
https://gayerie.dev/docs/spring/spring/aop.html



