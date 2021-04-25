/**
 * State based templating engine as a demonstration of a design with state machines.
 *
 * <p>
 * The story is a follows. When adding a 'mail merge' module in an application,
 * we want to avoid to use `eval(...)` to replace the tempate text by the
 * actual value text. Eval would increase the attack surface of an application
 * big time.
 * </p>
 *
 * <p>
 * So we opted for a better, hopefully more robust but also simple solution.
 * </p>
 *
 * <p>
 * Text processing can be done in various ways, but mainly two ways: Using
 * regular expressions, or processing the stream of characters and replacing
 * template words on the fly. We opted of the later approach.
 * </p>
 * 
 * The {@code templateengine.Engine} is the context of a state machine in
 * the Gof State pattern. The state class is implemented as an {@code enum},
 * which itself implements the {@code ObjIntConsumer} interface. See the class
 * diagram below.
 *
 * Typical usage of the templating engine is
 * <pre class='brush:java'> 
 *    Map&lt;Object, String&gt; map = Map.of(
 *        "teacher", "Pieter van den Hombergh",
 *        "mod", "Programing Concepts 2 (PRC2)"
 *    ); 
 *    Function&lt;String,String&gt; lookup = (s)  -&gt;  map.getOrDefault( s, ""); 
 *    new Engine( "{{", "}}", lookup )
 *       .reading( "letter.txt")
 *       .run();
 *
 *    // write to file. 
 *    new Engine( "{{", "}}", lookup )
 *       .reading( "letter.txt" )
 *       .writing( "mail-out.txt")
 *       .run();
 * </pre>
 * <h2>Implementation details</h2>
 *
 * Design of the state behaviour:
 * <br>
 * <img src='doc-files/templaterStateMachinex-i.svg' alt='templating engine state diagram'>
 *
 * <br>
 * There are 5 states: forwarding, prefix, collectkey, postfix, and escape.
 * <br>
 *
 * <img src='doc-files/engineclassesx.svg' alt='templating engine class diagram'>
 * <br>
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
package templateengine;
