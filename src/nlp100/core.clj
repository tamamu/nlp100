(ns nlp100.core)

(require '[clojure.set :as cset])

(clojure.string/reverse "stressed")

(apply str (map #(get "パタトクカシーー" %) [1 3 5 7]))

(apply str (interleave "パトカー" "タクシー"))

(map count (.split "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics." "[., ]+"))

(def nlp-04-str "Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can.")
(def nlp-04-init #{1 5 6 7 8 9 15 16 19})
(->> (.split nlp-04-str " ")
     (interleave (iterate inc 1) ,,,)
     (partition 2 ,,,)
     (map (fn [[k v]]
            (if (nlp-04-init k)
              {k (subs v 0 1)}
              {k (subs v 0 2)} )) ,,,)
     (apply merge ,,,))

(def nlp-05-str "I am an NLPer")
(defn nlp-05
  [s n]
  (partition n 1 s))
(nlp-05 nlp-05-str 2)
(nlp-05 (.split nlp-05-str "[., ]+") 2)

(def nlp-06-str-1 "paraparaparadise")
(def nlp-06-str-2 "paragraph")
(def nlp-06-x (into #{} (nlp-05 nlp-06-str-1 2)))
(def nlp-06-y (into #{} (nlp-05 nlp-06-str-2 2)))
(cset/union nlp-06-x nlp-06-y)
(cset/difference nlp-06-x nlp-06-y)
(cset/intersection nlp-06-x nlp-06-y)

(defn nlp-07
  [x y z]
  (format "%s時の%sは%s" x y z))
(nlp-07 12 "気温" 22.4)

(defn nlp-08-cipher
  [s]
  (->> (map (fn [x]
              (if (<= (int \a) (int x) (int \z))
                (char (- 219 (int x)))
                x))
            s)
       (apply str ,,,)))
(nlp-08-cipher (nlp-08-cipher "Hello World"))

