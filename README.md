# Mattc
[![](https://www.jitpack.io/v/a8kj7sea/mattc.svg)](https://www.jitpack.io/#a8kj7sea/mattc)

A tokenizer converts raw input text into a sequence of meaningful tokens by applying rules to identify language elements and report lexical errors.

## Usage example

You can find examples and related projects here:

- [nlpex](https://github.com/a8kj7sea/nlpex) - Simple NLP tokenizer with mattc


# todo

- لازم اضيف error handler عشان يكون في implement واضح للerror عشان لو فرضا فلان حب يعمل implement جديد لل tokenizer يكون في error handler يعني لنقل فرضا صار ايرور معين وباقي البنية صحيحة ما يكون ماثر بشكل غلط على البقية فا ممكن اعمل حل جيد لانه الحل الحالي مؤقت والreason لحاله ما بيكفي
- لازم اسفتفيد من الscanners / state عشان لو كان النص كبير ما يصير مشاكل 
- لازم جدا جدا اركز عموضوع الاداء لانه حاليا المشروع صغير وممكن يكبر ويسبب مشاكل 
- لازم اضيف post / pre scanners عشان موضوع الcontext يكون ادق
- لازم اخلي الrule اكثر مرونة لانه مش عاجبني منظرها ولا قوتها
