import Image from "next/image";
import { Layout } from "./components/layout";
import Head from "next/head";

export default function Home() {
  return (
    <div>

      <Head>
        <title>Whister Agendamentos</title>
      </Head>
      <Layout/>
    </div>
  );
}
