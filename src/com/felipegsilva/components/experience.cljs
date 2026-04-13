(ns com.felipegsilva.components.experience
  (:require [helix.core :refer [defnc $]]
            [helix.dom :as d]))

(def jobs
  [{:title "Full Stack Software Developer"
    :company "Vinellu"
    :url nil
    :period "August 2025 – Present"
    :bullets ["Designed and led backend development of a scalable recommendation platform using Supabase, Edge Functions, and PostgreSQL, ensuring high availability and seamless mobile client integration."
              "Implemented complex engagement features: real-time social feed, secure authentication, and an automatic wine label identification pipeline via the OpenAI API."
              "Optimized search performance by implementing an inverted index for direct query execution, reducing average latency from 4.52s to 500ms (~9x improvement) on the platform's main search route."
              "Developed and integrated ML models for visual detection and personalized recommendation using Sentence-BERT (SBERT) for embeddings and HNSW algorithms for efficient vector search."]}
   {:title "Software Developer"
    :company "passagemdeonibus.com"
    :url "https://www.passagemdeonibus.com"
    :period "March 2025 – July 2025"
    :bullets ["Optimized the CI/CD pipeline for a Hugo static site (200,000+ pages), cutting deploy time by 58% (12h to 5h) through build segmentation and advanced caching strategies."
              "Engineered a concurrent Python health-check system to automatically detect and fix broken routes and images, ensuring content integrity at scale."
              "Implemented a robust caching layer for route data, eliminating redundant database requests and significantly improving site generation and SEO ranking."]}
   {:title "Product Engineer (Full Stack)"
    :company "moclojer"
    :url "https://www.moclojer.com"
    :period "August 2024 – March 2025"
    :bullets ["Developed and maintained backend services in Clojure/ClojureScript using Stuart Sierra's component system alongside Redis, LocalStack, Docker, and PostgreSQL."
              "Architected an automated monitoring and logging system via Clojure metaprogramming, dynamically instrumenting namespaces and reducing imperative code to improve system observability."
              "Built a GitHub Apps-integrated sync engine for automated authentication and file mirroring between organization and user repositories."]}])

(defnc exp-bullet [{:keys [text]}]
  (d/li {:class "text-sm leading-relaxed flex gap-2 items-start"}
        (d/span {:class "text-yellow-600 mt-0.5 flex-shrink-0 select-none"} "▸")
        (d/span {} text)))

(defnc exp-item [{:keys [title company url period bullets is-dark?]}]
  (d/div {:class "mb-10"}
         (d/div {:class "flex flex-col md:flex-row md:justify-between md:items-baseline mb-3 gap-1"}
                (d/div {:class "flex items-center gap-2 flex-wrap"}
                       (d/span {:class "font-bold"} title)
                       (d/span {:class "text-gray-500 mx-1"} "|")
                       (if url
                         (d/a {:href url
                               :target "_blank"
                               :class "hover:text-yellow-600 transition-all duration-75 underline"}
                              company)
                         (d/span {} company)))
                (d/span {:class (str "text-sm " (if is-dark? "text-gray-400" "text-gray-500"))} period))
         (d/ul {:class "space-y-2"}
               (map-indexed
                (fn [i b]
                  ($ exp-bullet {:key i :text b}))
                bullets))))

(defnc experience [{:keys [is-dark?]}]
  (d/section {:id "experience" :class "w-full py-12"}
             (d/h2 {:class "text-2xl font-bold mb-2"} "Experience")
             (d/div {:class (str "border-b mb-8 " (if is-dark? "border-gray-700" "border-gray-200"))})
             (map (fn [{:keys [title company url period bullets]}]
                    ($ exp-item {:key title
                                 :title title
                                 :company company
                                 :url url
                                 :period period
                                 :bullets bullets
                                 :is-dark? is-dark?}))
                  jobs)))
