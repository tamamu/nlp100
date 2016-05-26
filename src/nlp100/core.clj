(ns nlp100.core)

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
