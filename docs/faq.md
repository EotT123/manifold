---
layout: default
---

# Manifold F.A.Q.s - Frequently Asked Questions (and Answers)

[Common Questions](#common-questions) • [Getting Help](#getting-help) • [Troubleshooting](#troubleshooting)


## Common Questions

#### Q: Does Manifold support Java 21? 17? 8?
Manifold fully supports all LTS versions since JDK 8, which includes 8, 11, 17, and 21. Additionally, manifold works with
the latest non-LTS version. Manifold also fully supports the Java Platform Module System (JPMS).

#### Q: Manifold is somehow using Java internal APIs to do its magic. Could it break in a future version of Java?
Unlikely.  Java internal APIs can and do change from version to version, sometimes dramatically, however Manifold always
adjusts to changes ahead of Java releases. To date, Manifold has adapted to eight major Java versions since its debut,
always well in advance of Oracle's official release schedule.  

#### Q: Doesn't Kotlin do all this already?
No. While there are bits of overlap such as properties, Kotlin does not have most of Manifold's features. Notably,
it does not offer anything similar to Manifold's core feature, the type manifold, which is the basis for `manifold-sql`,
`manifold-json`, `manifold-graphql`, `manifold-xml`, and a multitude of others. In addition, most of manifold's extensions
to the Java language are not present in Kotlin, these include:
- true delegation
- structural typing
- tuples
- unit expressions
- extension classes
- type-safe templates
- conditional compilation
- ...and more

Importantly, Kotlin is an entirely separate language from Java, while Manifold is a compiler plugin that supplements Java 
with new features. Add Manifold to any Java project and incorporate features of your choosing.

#### Q: Is Manifold free?
Yes, the Manifold project is [open source](https://github.com/manifold-systems/manifold) and publicly available on
github, free for use via Apache License 2.0.

The Manifold [plugins for IntelliJ and Android Studio](https://plugins.jetbrains.com/plugin/10057-manifold/) are also
[open source](https://github.com/manifold-systems/manifold-ij) and freely available.

#### Q: Does Manifold work with Maven?  Gradle?
Yes.  Please refer to the [Maven](http://manifold.systems/docs.html#maven) and [Gradle](http://manifold.systems/docs.html#gradle)
sections of the [Setup](https://github.com/manifold-systems/manifold#projects) instructions detailed in the subproject[s]
you are using. 

#### Q: Does Manifold provide IDE support?
Yes.  The [Manifold plugin](https://plugins.jetbrains.com/plugin/10057-manifold) provides comprehensive support for
**IntelliJ IDEA** and **Android Studio**.

Download / Update the plugin directly from within the IDE:

<kbd>Settings</kbd> ➜ <kbd>Plugins</kbd> ➜ <kbd>Marketplace</kbd> ➜ search: `Manifold` 

<iframe frameborder="none" width="245px" height="48px" src="https://plugins.jetbrains.com/embeddable/install/10057">
</iframe>
  
>Note: The IDE notifies you within 24 hours when an update is available and gives you the opportunity to sync.

#### Q: Do I need a license for the IntelliJ plugin?
No. The [plugin](https://plugins.jetbrains.com/plugin/10057-manifold/) is no longer commercial and is available for free
from JetBrains Marketplace.

#### Q: How do I get manifold-*fill-in-blank* working with my project? 
Add the manifold-*fill-in-blank* dependency[s] to your project along with the `-Xplugin:Manifold` javac argument, the
setup is sensitive to the version of Java you are using, generally whether you are using Java 8 or 9+. See the
[Setup](https://github.com/manifold-systems/manifold#projects) docs within the manifold-*fill-in-the-blank* subproject for
complete instructions.
 
## Getting Help

#### Q: Where can I find help?

**Discussions**
Join our [Discord server](https://discord.gg/9x2pCPAASn) to start
a discussion, ask questions, provide feedback, etc.

**Report A Bug**
The Manifold project uses github issues to track bugs, features, and other requests.  If you discover a bug, have a
feature request, or an idea go [here](https://github.com/manifold-systems/manifold/issues) and let it be known. Expect a
response within 24 hours.

**Private E-mail**
If your question or issue is more pressing or confidential, don't hesitate to send an email to [info@manifold.systems](mailto:info@manifold.systems).

#### Q: I've read the docs page.  Can I learn more about Manifold elsewhere?

Links to recently published Manifold articles are available on the [Articles](http://manifold.systems/articles/articles.html) 
page.  There is always another article on the way, check back for more. 

## Troubleshooting

#### Q: I updated to the latest Manifold IntelliJ plugin and now IntelliJ is complaining with error messages.  What's wrong?
You probably need to update your project dependencies to use the latest manifold release.  If your project's
dependencies are out of sync, the plugin tells you which version of manifold you need with in a warning message
when you load your project.  You can find the latest releases [here](https://github.com/manifold-systems/manifold/tags).

**Important:** If you are using Maven or Gradle, you must update your build files -- do not change the Module dependencies from 
IntelliJ's UI. Please refer to the [Maven](http://manifold.systems/docs.html#maven) and [Gradle](http://manifold.systems/docs.html#gradle)
sections of the [Setup](https://github.com/manifold-systems/manifold#projects) instructions detailed in the subproject[s] you are using.

Please [make some noise](https://discord.gg/9x2pCPAASn) if you can't get it
working, chances are you're not alone and help will arrive soon.

#### Q: I defined some useful *extension methods*, but they aren't showing up in my other project. How can I share them as a dependency?
The module with your extension methods must declare that it should be processed for extension methods. Do that with the
`Contains-Sources` JAR *manifest entry*. For instance, from Maven:
```xml
  <manifestEntries>
      <!--class files as source must be available for extension method classes-->
      <Contains-Sources>java,class</Contains-Sources>
  </manifestEntries>
```
Please see the documentation for making [extension libraries](https://github.com/manifold-systems/manifold/tree/master/manifold-deps-parent/manifold-ext#extension-libraries).

### Q: I defined a new *extension class* with some extension methods, IntelliJ flags usage of them as errors. What's wrong?
Sometimes IntelliJ's cache is out of sync with extensions. Generally, whenever IntelliJ's editor displays an error for legal usage
of a manifold feature, you can often remedy the problem by making a small change at the use site and then undoing the change.
Failing that, it is best to close and reload the project. Please report errors of this nature as [issues](https://github.com/manifold-systems/manifold/issues)
on manifold's github repo.

### Q: Who uses Manifold?

A sampling of companies currently using manifold:

<img width="70%" height="70%" src="http://manifold.systems/images/companies.png">